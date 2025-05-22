package facul.project.ab_API.Service;

import facul.project.ab_API.DataBase.Entity.VideosEntity;
import facul.project.ab_API.DataBase.Repository.VideoRepository;
import facul.project.ab_API.Dto.VideoRequestDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;

    @Getter
    @Value("${video.folder-path}")
    private String videosPath;

    public List<VideosEntity> importarTodosOsVideosDaPasta(List<VideoRequestDTO> videoRequests) {
        List<VideosEntity> salvos = new ArrayList<>();

        System.out.println("Caminho base dos vídeos: " + videosPath);

        for (VideoRequestDTO req : videoRequests) {
            // Use Paths.get corretamente
            Path videoPath = Paths.get(videosPath).resolve(req.getFilename());
            File file = videoPath.toFile();

            System.out.println("Verificando existência do arquivo: " + videoPath);

            if (file.exists()) {
                VideosEntity video = new VideosEntity();
                video.setTitle(req.getTitle());
                video.setDescription(req.getDescription());
                video.setUrl(file.getAbsolutePath());

                salvos.add(videoRepository.save(video));
            } else {
                System.out.println("⚠ Arquivo não encontrado: " + videoPath);
            }
        }

        return salvos;
    }



    public List<VideosEntity> deletedVideosById(@RequestBody List<Long> ids) {
        List<VideosEntity> deletedVideos = new ArrayList<>();
        for (Long id : ids) {
            VideosEntity video = videoRepository.findById(id).orElse(null);
            if (video != null) {
                videoRepository.delete(video);
                deletedVideos.add(video);
            }
        }
        return deletedVideos;
    }

}
