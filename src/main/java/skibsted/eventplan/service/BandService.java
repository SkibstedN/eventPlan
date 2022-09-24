package skibsted.eventplan.service;

import org.springframework.stereotype.Service;
import skibsted.eventplan.model.Band;
import skibsted.eventplan.repository.BandRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BandService implements IBandService{

    private BandRepository bandRepository;

    public BandService(BandRepository bandRepository) {this.bandRepository = bandRepository;}

    @Override
    public Set<Band> findAll() {
        Set<Band> set = new HashSet<>();
        bandRepository.findAll().forEach(set::add);
        return null;
    }

    @Override
    public Band save(Band object) {
       return bandRepository.save(object);

    }

    @Override
    public void delete(Band object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Band> findById(Long aLong) {
        return Optional.empty();
    }
}
