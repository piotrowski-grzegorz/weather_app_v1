package db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityWeatherDbTest {

    private static final CityWeatherDb dataBase = new CityWeatherDb();

    @Test
    void change() {
        // given
        final long id = 1L;
        final String cityName = "Warsaw";
        final CityDataEntity cityDataEntity = new CityDataEntity();
        cityDataEntity.setId(id);
        cityDataEntity.setName(cityName);
        dataBase.add(cityDataEntity);

        final CityDataEntity changedCityDataEntity = new CityDataEntity();
        changedCityDataEntity.setId(id);
        final String newName = cityName + "AAA";
        changedCityDataEntity.setName(newName);
        // when
        dataBase.change(changedCityDataEntity);
        // then
        final CityDataEntity result = dataBase.get(id);
        Assertions.assertEquals(result.getName(), newName);
    }


}