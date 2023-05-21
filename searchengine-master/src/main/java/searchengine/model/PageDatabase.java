package searchengine.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "page")
@Getter
@Setter
public class PageDatabase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "site_id")
    private SiteDatabase site;

    private String path;

    private int code;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String content;
}
