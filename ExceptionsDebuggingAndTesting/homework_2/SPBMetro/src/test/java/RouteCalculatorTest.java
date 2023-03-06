
import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.*;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    HashMap<String, Station> metroMap;

    RouteCalculator routeCalculator;
    StationIndex stationIndex = new StationIndex();

    @Override
    protected void setUp() {

        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");
        Line line4 = new Line(4, "Четвертая");

        metroMap = new HashMap<>();

        metroMap.put("л1.с1", new Station("л1.с1", line1));
        metroMap.put("л1.с2", new Station("л1.с2", line1));
        metroMap.put("л1.с3", new Station("л1.с3", line1));
        metroMap.put("л2.с1", new Station("л2.с1", line2));
        metroMap.put("л2.с2", new Station("л2.с2", line2));
        metroMap.put("л2.с3", new Station("л2.с3", line2));
        metroMap.put("л2.с4", new Station("л2.с4", line2));
        metroMap.put("л3.с1", new Station("л3.с1", line3));
        metroMap.put("л3.с2", new Station("л3.с2", line3));
        metroMap.put("л3.с3", new Station("л3.с3", line3));
        metroMap.put("л4.с1", new Station("л4.с1", line4));
        metroMap.put("л4.с2", new Station("л4.с2", line4));
        metroMap.put("л4.с3", new Station("л4.с3", line4));
        metroMap.put("л4.с4", new Station("л4.с4", line4));


        metroMap.forEach((key, value) -> {
            stationIndex.addStation(value);
            switch (value.getLine().getNumber()) {
                case 1 -> line1.addStation(value);
                case 2 -> line2.addStation(value);
                case 3 -> line3.addStation(value);
                case 4 -> line4.addStation(value);
            }
        });


        routeCalculator = new RouteCalculator(stationIndex);
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        stationIndex.addLine(line4);
        stationIndex.addConnection(new ArrayList<>(Arrays.asList(metroMap.get("л1.с2"), metroMap.get("л2.с2"))));
        stationIndex.addConnection(new ArrayList<>(Arrays.asList(metroMap.get("л2.с3"), metroMap.get("л4.с2"))));
        stationIndex.addConnection(new ArrayList<>(Arrays.asList(metroMap.get("л3.с2"), metroMap.get("л1.с3"))));
        stationIndex.addConnection(new ArrayList<>(Arrays.asList(metroMap.get("л3.с3"), metroMap.get("л4.с3"))));

    }

    public void testCalculateDuration() {
        route = new ArrayList<>();
        route.add(metroMap.get("л4.с2"));
        route.add(metroMap.get("л4.с3"));
        route.add(metroMap.get("л3.с3"));
        route.add(metroMap.get("л3.с2"));
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute() {
        route = new ArrayList<>();
        route.add(metroMap.get("л2.с1"));
        route.add(metroMap.get("л2.с3"));

        assertEquals(routeCalculator.getShortestRoute(metroMap.get("л2.с1"), metroMap.get("л2.с3")), route);
    }


    public void testGetRouteOnTheLine() {
        route = new ArrayList<>();
        route.add(metroMap.get("л2.с1"));
        route.add(metroMap.get("л2.с3"));
        route.add(metroMap.get("л2.с2"));
        assertEquals(routeCalculator.getShortestRoute(metroMap.get("л2.с1"), metroMap.get("л2.с2")), route);
    }

    public void testGetRouteWithOneConnection() {
        route = new ArrayList<>();
        route.add(metroMap.get("л2.с1"));
        route.add(metroMap.get("л2.с3"));
        route.add(metroMap.get("л2.с2"));
        route.add(metroMap.get("л1.с2"));
        route.add(metroMap.get("л1.с1"));
        assertEquals(routeCalculator.getShortestRoute(metroMap.get("л2.с1"), metroMap.get("л1.с1")), route);
    }

    public void testGetRouteWithTwoConnections() {
        route = new ArrayList<>();
        route.add(metroMap.get("л1.с1"));
        route.add(metroMap.get("л1.с2"));
        route.add(metroMap.get("л2.с2"));
        route.add(metroMap.get("л2.с3"));
        route.add(metroMap.get("л4.с2"));
        route.add(metroMap.get("л4.с3"));
        route.add(metroMap.get("л4.с1"));
        assertEquals(routeCalculator.getShortestRoute(metroMap.get("л1.с1"), metroMap.get("л4.с1")), route);


    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}


