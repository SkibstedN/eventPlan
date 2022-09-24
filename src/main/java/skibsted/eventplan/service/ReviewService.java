package skibsted.eventplan.service;

import org.springframework.stereotype.Service;
import skibsted.eventplan.model.Review;
import skibsted.eventplan.repository.ReviewRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ReviewService implements IReviewService {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {this.reviewRepository = reviewRepository;}


    @Override
    public Set<Review> findAll() {
        Set<Review> set = new HashSet<>();
        reviewRepository.findAll().forEach(set::add);
        return null;
    }

    @Override
    public Review save(Review object) {
        reviewRepository.save(object);
        return null;
    }

    @Override
    public void delete(Review object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Review> findById(Long aLong) {
        return Optional.empty();
    }
}
