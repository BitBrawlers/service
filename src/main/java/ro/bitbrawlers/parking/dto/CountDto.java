package ro.bitbrawlers.parking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountDto {
    private Integer emptySpotCount;
    private Integer totalSpotCount;
}
