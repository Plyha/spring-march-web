package ru.specialist.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.specialist.spring.entity.Tag;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query(value = """
                    select
                        t.*
                    from
                        tag t
                            inner join post_tag pt
                                on t.tag_id = pt.tag_id
                            group by t.tag_id
                            order by count(*) desc
                    """, nativeQuery = true)
    List<Tag> findAllSortedByPostCount();


}
