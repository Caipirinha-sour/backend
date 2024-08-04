package com.hackathon.api.shared.configuration.seed;

import com.hackathon.api.publishing.domain.models.entities.Tag;
import com.hackathon.api.publishing.infrastructure.persistence.repositories.ITagRepository;
import com.hackathon.api.security.domain.models.entities.Citizen;
import com.hackathon.api.security.domain.models.entities.Organization;
import com.hackathon.api.security.infrastructure.persistence.repositories.ICitizenRepository;
import com.hackathon.api.security.infrastructure.persistence.repositories.IOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private ITagRepository tagRepository;

    @Autowired
    private ICitizenRepository citizenRepository;

    @Autowired
    private IOrganizationRepository organizationRepository;

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

    private void seedOrganizationData() {
        var organizationsList = organizationRepository.findAll();

        if (!organizationsList.isEmpty()) {
            return;
        }

        List<Organization> organizations = List.of(
                new Organization(
                        "helpingHands",
                        "password123",
                        "contact@helpinghands.org",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4RgnchbxNejUMFZGB3r1aIy04rL49oq8eCw&s",
                        "We provide aid and resources to those in need.",
                        "123-456-7890"
                ),
                new Organization(
                        "safeHarbor",
                        "securePass456",
                        "info@safeharbor.org",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4RgnchbxNejUMFZGB3r1aIy04rL49oq8eCw&s",
                        "Offering shelter and support to displaced families.",
                        "987-654-3210"
                ),
                new Organization(
                        "greenEarth",
                        "ecoFriendly789",
                        "support@greenearth.org",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4RgnchbxNejUMFZGB3r1aIy04rL49oq8eCw&s",
                        "Promoting environmental sustainability and conservation.",
                        "555-123-4567"
                ),
                new Organization(
                        "careAndCure",
                        "healing1234",
                        "contact@careandcure.org",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4RgnchbxNejUMFZGB3r1aIy04rL49oq8eCw&s",
                        "Providing medical aid and health resources to communities.",
                        "444-555-6666"
                )
        );

        organizationRepository.saveAll(organizations);
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
        seedOrganizationData();
    }
}
