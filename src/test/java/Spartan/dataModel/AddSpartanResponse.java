package Spartan.dataModel;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Builder
public class AddSpartanResponse {

    private String success;

    SpartanResponse data;
}
