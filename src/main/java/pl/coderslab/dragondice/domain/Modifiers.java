package pl.coderslab.dragondice.domain;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Modifiers {
    private int strMod;
    private int dexMod;
    private int conMod;
    private int intMod;
    private int wisMod;
    private int chaMod;
}
