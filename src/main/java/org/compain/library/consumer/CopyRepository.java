package org.compain.library.consumer;

import org.compain.library.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopyRepository extends JpaRepository<Copy,Long> {

    @Query(value = "SELECT count(*) FROM copies WHERE id_book= :idBook AND id_library= :idLibrary" ,
    nativeQuery = true
    )
    int countCopiesNumberByBookAndLibrary(Long idBook, Long idLibrary);

    @Query(value = "SELECT count(*) FROM copies WHERE id_book= :idBook AND id_library= :idLibrary AND available= true" ,
            nativeQuery = true
    )
    int countAvailableCopiesNumberByBookAndLibrary(Long idBook, Long idLibrary);
}
