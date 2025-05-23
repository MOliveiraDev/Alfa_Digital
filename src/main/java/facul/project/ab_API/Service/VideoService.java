package facul.project.ab_API.Service;

import facul.project.ab_API.DataBase.Entity.VideosEntity;
import facul.project.ab_API.DataBase.Repository.VideosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VideoService {

    @Value("${supabase.bucket-url}")
    private String bucketUrl;

    private final VideosRepository videosRepository;

    public List<Map<String, String>> getAllVideos() {
        return videosRepository.findAll().stream().map(video -> {
            Map<String, String> map = new HashMap<>();
            map.put("title", video.getTitle());
            map.put("description", video.getDescription());
            map.put("url", bucketUrl + video.getFilename());
            return map;
        }).collect(Collectors.toList());
    }

    public VideosEntity importVideo(VideosEntity video) {
        return videosRepository.save(video);
    }

    public VideosEntity UpdateVideo(Long id, VideosEntity newVideo) {
        VideosEntity existente = videosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vídeo não encontrado com ID: " + id));

        existente.setTitle(newVideo.getTitle());
        existente.setDescription(newVideo.getDescription());
        existente.setFilename(newVideo.getFilename());
        return videosRepository.save(existente);
    }

}
