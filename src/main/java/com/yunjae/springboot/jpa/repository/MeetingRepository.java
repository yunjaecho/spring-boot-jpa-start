package com.yunjae.springboot.jpa.repository;

import com.yunjae.springboot.jpa.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {

    List<Meeting> findAllByTitleLikeIgnoreCase(String title);
}
