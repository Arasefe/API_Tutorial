package Spartan.dataModel;


import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpartanResponse {
    private int id;

    private String name;

    private String gender;

    private long phone;
}
