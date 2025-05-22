package facul.project.ab_API.Controller;


import facul.project.ab_API.DataBase.Entity.VideosEntity;
import facul.project.ab_API.DataBase.Repository.VideoRepository;
import facul.project.ab_API.Dto.VideoRequestDTO;
import facul.project.ab_API.Dto.VideoResponseDTO;
import facul.project.ab_API.Service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/videos")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;
    private final VideoRepository videoRepository;

    @PostMapping("/import")
    public ResponseEntity<List<VideosEntity>> importarVideos(@RequestBody List<VideoRequestDTO> videoRequests) {
        try {
            List<VideosEntity> videos = videoService.importarTodosOsVideosDaPasta(videoRequests);
            return ResponseEntity.ok(videos);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity<List<VideosEntity>> deletedVideosById(@RequestParam List<Long> ids) {
        try {
            List<VideosEntity> deletedVideos = videoService.deletedVideosById(ids);
            return ResponseEntity.ok(deletedVideos);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }


    @GetMapping("/watch-all")
    public ResponseEntity<List<VideoResponseDTO>> watchAllVideos() {
        List<VideosEntity> videos = videoRepository.findAll();
        List<VideoResponseDTO> videoResponses = videos.stream()
                .map(video -> {
                    String filename = video.getUrl() != null ? video.getUrl().substring(video.getUrl().lastIndexOf("\\") + 1) : "";
                    String videoAccessUrl = "https://alfadigital-api-deploy.onrender.com/videos/watch/" + filename;

                    return new VideoResponseDTO(
                            video.getTitle(),
                            video.getDescription(),
                            videoAccessUrl
                    );
                }).toList();
        return ResponseEntity.ok(videoResponses);
    }

    @GetMapping("/watch/{filename}")
    public ResponseEntity<Resource> streamVideo(@PathVariable String filename) {
        try {
            Path videoPath = Paths.get(videoService.getVideosPath(), filename);
            Resource videoResource = new UrlResource(videoPath.toUri());

            if (!videoResource.exists()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(videoPath))
                    .body(videoResource);

        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
    }


}
