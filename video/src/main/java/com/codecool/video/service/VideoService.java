package com.codecool.video.service;

import com.codecool.video.exception.VideoNotFoundException;
import com.codecool.video.model.Video;
import com.codecool.video.model.VideoDTO;
import com.codecool.video.repository.VideoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;
    private final RecommendationServiceCaller recommendationServiceCaller;

    public List<Video> getAll() {
        return videoRepository.findAll();
    }

    public Optional<Video> get(Long id) {
        return videoRepository.findById(id);
    }

    public VideoDTO getVideoDTO(Long id) {
        return get(id).map(video ->
                VideoDTO.builder()
                        .video(video)
                        .recommendations(recommendationServiceCaller.getRecommendationsForVideo(id))
                        .build()
        ).orElseThrow(VideoNotFoundException::new);
    }

    public void add(String title, String url) {
        videoRepository.save(Video.builder()
                .title(title)
                .url(url)
                .build()
        );
    }

    public void delete(Long id) {
        videoRepository.deleteById(id);
        recommendationServiceCaller.deleteForVideo(id);
    }

    //Test data
//    @PostConstruct
//    public void afterInit() {
//        List<String> urls = new ArrayList<>();
//        urls.add("h9PKIgpb2Bs");
//        urls.add("jTN_IYDKTiE");
//        urls.add("fzBDw279rJQ");
//        urls.add("KOcAxiYwryY");
//        for(int i = 1; i < 5; i++) {
//            Video video = Video.builder().name("Video " + i).url(urls.get(i-1)).build();
//            videoRepository.save(video);
//        }
//    }
}
