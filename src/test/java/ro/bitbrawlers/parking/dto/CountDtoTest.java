package ro.bitbrawlers.parking.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountDtoTest {

    CountDto countDto = new CountDto(3, 8);
    CountDto countDtoEmpty = new CountDto();


    @Test
    void emptySpotCountIsLessThanTotalCount(){
        Assertions.assertTrue(countDto.getEmptySpotCount() < countDto.getTotalSpotCount());
    }

    @Test
    void emptySpotCount(){
        Assertions.assertEquals( (Integer) 3,countDto.getEmptySpotCount());
    }

    @Test
    void totalSpotCount(){
        Assertions.assertEquals( (Integer) 8,countDto.getTotalSpotCount());
    }

    @Test
    void emptySpotCountSetter() {
        countDtoEmpty.setEmptySpotCount(5);
        Assertions.assertEquals((Integer) 5, countDtoEmpty.getEmptySpotCount());
    }

    @Test
    void totalSpotCountSetter() {
        countDtoEmpty.setTotalSpotCount(8);
        Assertions.assertEquals((Integer) 8, countDtoEmpty.getTotalSpotCount());
    }

}
