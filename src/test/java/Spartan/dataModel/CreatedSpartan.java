package Spartan.dataModel;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatedSpartan {
    String success;
    Spartan data;
}
