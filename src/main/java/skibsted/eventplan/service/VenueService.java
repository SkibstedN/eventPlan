package skibsted.eventplan.service;

import org.springframework.stereotype.Service;
import skibsted.eventplan.model.Venue;
import skibsted.eventplan.repository.VenueRepository;

import java.util.Optional;
import java.util.Set;

@Service
public class VenueService implements IVenueservice{
    private VenueRepository venueRepository;

    public VenueService(VenueRepository venueRepository)  { this.venueRepository = venueRepository; }

    @Override
    public Set<Venue> findAll() {
        return null;
    }

    @Override
    public Venue save(Venue object) {
        return null;
    }

    @Override
    public void delete(Venue object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Venue> findById(Long aLong) {
        return venueRepository.findById(aLong);
    }
}
