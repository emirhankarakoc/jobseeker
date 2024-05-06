package com.karakoc.starterproject.cv.scheme;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CVRepository extends JpaRepository<CVSchema,String> {
}
