package Spartan.dataModel;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Spartan {
    int id;
    @Builder.Default
    String name="Aras";
    @Builder.Default
    String gender="Male";
    @Builder.Default
    long phone=6123467397L;

    @Override
    public String toString() {
        return "Spartan[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone=" + phone +
                ']';
    }
}
