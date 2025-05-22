package facul.project.ab_API.DataBase.Repository;

import facul.project.ab_API.DataBase.Entity.VideosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository <VideosEntity, Long> {
    boolean existsByUrl(String url);
}
