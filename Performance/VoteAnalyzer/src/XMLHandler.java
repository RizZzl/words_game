import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.SimpleDateFormat;
import java.util.HashMap;

public class XMLHandler extends DefaultHandler {

    private Voter voter;
    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private HashMap<Voter, Integer> voterCounts;

    int limit = 5_000_000;
    int number = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("voter") && number < limit) {
            String name = attributes.getValue("name");
            String birthDate = attributes.getValue("birthDay");
            try {
                DBConnection.countVoter(name, birthDate);

                if (number % 1_000_000 == 0) {
                    DBConnection.executeMultiInsert();
                    DBConnection.clearRequest();
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            number++;
        }


//        try {
//            if (qName.equals("voter") && voter == null) {
//                Date birthDay = birthDayFormat.parse(attributes.getValue("birthDay"));
//                voter = new Voter(attributes.getValue("name"), birthDay);
//            }
//            else if (qName.equals("visit") && voter != null) {
//                int count = voterCounts.getOrDefault(voter, 0);
//                voterCounts.put(voter, count + 1);
//
//            }
//        } catch (ParseException e) {
//            System.out.println(e.getMessage());
//        }
    }

//    @Override
//    public void endElement(String uri, String localName, String qName) throws SAXException {
//        if (qName.equals("voter")) {
//            voter = null;
//        }
//    }
//
//    public void printDuplicatedVoters() {
//        for (Voter voter : voterCounts.keySet()) {
//            int count = voterCounts.get(voter);
//            if (count > 1) {
//                System.out.println(voter.toString() + " - " + count);
//            }
//        }
//    }
}
