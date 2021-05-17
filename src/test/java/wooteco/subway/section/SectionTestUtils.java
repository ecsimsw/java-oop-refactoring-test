package wooteco.subway.section;

import org.springframework.stereotype.Component;
import wooteco.subway.line.dao.LineDao;
import wooteco.subway.line.domain.Line;
import wooteco.subway.line.service.LineService;
import wooteco.subway.section.dao.SectionDao;
import wooteco.subway.section.domain.Section;
import wooteco.subway.station.domain.Station;
import wooteco.subway.station.dto.StationResponse;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Component
public class SectionTestUtils {

    private final LineService lineService;
    private final SectionDao sectionDao;

    public SectionTestUtils(LineService lineService, SectionDao sectionDao) {
        this.lineService = lineService;
        this.sectionDao = sectionDao;
    }

    public void printStationIds(final Line line){
        for(final Long stationId : lineService.allStationIdInLine(line)){
            System.out.print(stationId + " ");
        }
        System.out.println();
    }

    public void assertStationOrder(final Line line, final StationResponse... stations){
        int index = 0;
        for(final Long stationId : lineService.allStationIdInLine(line)){
            assertThat(stationId).isEqualTo(stations[index++].getId());
        }
    }
}
