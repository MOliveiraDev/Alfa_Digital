package facul.project.ab_API.Controller;

import facul.project.ab_API.DataBase.Entity.VideosEntity;
import facul.project.ab_API.Service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/videos")
@RestController
public class VideoController {

    private final VideoService videoService;

    @GetMapping
    public ResponseEntity<List<Map<String, String>>> getAllVideos() {
        List<Map<String, String>> videos = videoService.getAllVideos();
        return ResponseEntity.ok(videos);
    }

    @PostMapping("/import")
    public ResponseEntity<VideosEntity> saveVideo(@RequestBody VideosEntity video) {
        return ResponseEntity.status(HttpStatus.CREATED).body(videoService.importVideo(video));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideosEntity> atualizarVideo(@PathVariable Long id, @RequestBody VideosEntity newVideo) {
        VideosEntity atualizado = videoService.UpdateVideo(id, newVideo);
        return ResponseEntity.ok(atualizado);
    }

}
