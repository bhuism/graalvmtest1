package nl.appsource.graalvm.test1;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CatResponse {

    String _id;
    String _v;
    String user;
    String text;
    Date updatedAt;
    Date sendDate;
    Boolean deleted;
    String source;
    Boolean used;
    String type;

}
