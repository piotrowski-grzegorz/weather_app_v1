package db;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CityWeatherDbTest {

    private static final CityWeatherDb dataBase = new CityWeatherDb();

    @Test
    void should_change_entity() {
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
        final Optional<CityDataEntity> resultOpt = dataBase.get(id);
        final String name = resultOpt.orElseThrow().getName();
        Assertions.assertEquals(name, newName);
    }

    @Test
    void should_get_entity_by_id() {
        //given
        final long id = 1L;
        final String cityName = "Warsaw";
        final CityDataEntity cityDataEntity = new CityDataEntity();
        cityDataEntity.setId(id);
        cityDataEntity.setName(cityName);
        dataBase.add(cityDataEntity);

        //when
        final CityDataEntity result = dataBase.get(id).orElseThrow();

        // then
        Assertions.assertEquals(result.getName(), cityName);

    }
}