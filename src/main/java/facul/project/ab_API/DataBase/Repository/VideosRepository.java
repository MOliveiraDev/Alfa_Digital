package facul.project.ab_API.DataBase.Repository;

import facul.project.ab_API.DataBase.Entity.VideosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideosRepository extends JpaRepository<VideosEntity, Long> {
}
