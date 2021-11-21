package Spartan.dataModel;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class SpartanList {
    List<Spartan> spartans;
}
