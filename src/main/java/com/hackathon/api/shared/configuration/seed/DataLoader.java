package com.hackathon.api.shared.configuration.seed;

import com.hackathon.api.publishing.domain.models.entities.Tag;
import com.hackathon.api.publishing.infrastructure.persistence.repositories.ITagRepository;
import com.hackathon.api.security.domain.models.entities.Citizen;
import com.hackathon.api.security.infrastructure.persistence.repositories.ICitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private ITagRepository tagRepository;

    @Autowired
    private ICitizenRepository citizenRepository;

    private void seedCitizenData() {
        var citizensList = citizenRepository.findAll();

        if (!citizensList.isEmpty()) {
            return;
        }

        citizenRepository.save(new Citizen(
        "MaryJenn",
        "password123",
            "mary.jenn@test.com",
        "https://icons.iconarchive.com/icons/iconarchive/robot-avatar/256/Yellow-5-Minion-icon.png"
        ));
    }

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
        seedCitizenData();
    }
}
