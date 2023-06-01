package edu.fpdual.webapplication.dto;

import edu.fpdual.webapplication.annotations.Model;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Model(type = "Data",version = "1.0", date = "01/06/2023")
public class Profile {
    //que se pueda cambiar todo aqui
    private int userId;
    private String description;
    private String email;
    private String link;
    private String location;
    private int phone;

    public Profile(String description, String email, String link, String location, int phone) {
        this.description = description;
        this.email = email;
        this.link = link;
        this.location = location;
        this.phone = phone;
    }

    public Profile(int userId, String email) {
        this.userId = userId;
        this.email = email;
    }
}
