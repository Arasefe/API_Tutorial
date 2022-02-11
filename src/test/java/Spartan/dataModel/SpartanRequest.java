package Spartan.dataModel;

import lombok.*;



//@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Builder
public class SpartanRequest {

    private String name;

    private String gender;

    private long phone;
}
