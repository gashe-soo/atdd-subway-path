package nextstep.subway.map.ui;

import nextstep.subway.map.application.MapService;
import nextstep.subway.map.dto.MapResponse;
import nextstep.subway.map.dto.PathResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapController {

    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping(value = "/maps", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MapResponse> loadMap() {
        MapResponse mapResponse = mapService.findAllLineAndStation();
        return ResponseEntity.ok().body(mapResponse);
    }

}