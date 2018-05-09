package com.yunjae.springboot.jpa;


import com.yunjae.springboot.jpa.entity.Meeting;
import com.yunjae.springboot.jpa.repository.MeetingRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeetingRepositoryTest {
    @Autowired
    private MeetingRepository repository;

    @Test
    public void di() {
        assertThat(repository).isNotNull();
    }

    @Test
    public void findByTitle() {
        Meeting meeting = new Meeting();
        meeting.setTitle("Chotom73");
        repository.save(meeting);

        List<Meeting> result = repository.findAllByTitleLikeIgnoreCase("cho%");
        assertThat(result).hasSize(1);
    }

}
