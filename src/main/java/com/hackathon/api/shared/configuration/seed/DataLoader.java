package com.hackathon.api.shared.configuration.seed;

import com.hackathon.api.publishing.domain.models.entities.Tag;
import com.hackathon.api.publishing.infrastructure.persistence.repositories.ITagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private ITagRepository tagRepository;

    private void seedTagData() {
        var tagsList = tagRepository.findAll();

        if (!tagsList.isEmpty()) {
            return;
        }

        tagRepository.save(new Tag("Prevention"));
        tagRepository.save(new Tag("News"));
        tagRepository.save(new Tag("Alert"));
        tagRepository.save(new Tag("Refugees"));
    }

    @Override
    public void run(String... args) throws Exception {
        seedTagData();
    }
}
