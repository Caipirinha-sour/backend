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
        "https://avatars.githubusercontent.com/u/97687796?v=4"
        ));
    }

    private void seedOrganizationData() {
        var organizationsList = organizationRepository.findAll();

        if (!organizationsList.isEmpty()) {
            return;
        }

        List<Organization> organizations = List.of(
                new Organization(
                        "UrbanResilience Fund",
                        "password123",
                        "contact@helpinghands.org",
                        "https://drive.google.com/file/d/1z2okf6cPTJg8Ioat20UV4Gb9PrQohekb/view",
                        "Families affected by the El Niño phenomenon",
                        "(+51) 1 345 6789"
                ),
                new Organization(
                        "GreenEarth Foundation",
                        "securePass456",
                        "info@safeharbor.org",
                        "https://drive.google.com/file/d/1Mfar5-trpeh2P_f5Ul5N9IpNjgiL-8IP/view",
                        "Reforestation and conservation of tropical forests",
                        "(+51) 1 234 5678"
                ),
                new Organization(
                        "ClimateAction Network",
                        "ecoFriendly789",
                        "support@greenearth.org",
                        "https://drive.google.com/file/d/1zqeALkrKkeg6js6iMqTAQHkSVh7uzGF0/view",
                        "Funding for renewable energy projects in rural communities",
                        "(+55) 21 2345 6789"
                ),
                new Organization(
                        "Relief Network USA",
                        "healing1234",
                        "contact@careandcure.org",
                        "https://drive.google.com/file/d/1YC7UPeemCYOM_69DY6lcKwW38rHno_aL/view",
                        "Emergency relief and disaster reconstruction assistance",
                        "(+1) 800-555-0199"
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
