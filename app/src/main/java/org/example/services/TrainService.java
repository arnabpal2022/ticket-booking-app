package org.example.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.example.entitites.Train;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TrainService {
    private List<Train> trainList;
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String TRAINS_DB_PATH = "app/src/main/java/org/example/localdb/trains.json";

    public TrainService() throws IOException {
        File trains = new File(TRAINS_DB_PATH);
        trainList = objectMapper.readValue(trains, new TypeReference<List<Train>>() {});
    }

    public List<Integer> fetchSeats(Train train){
        return train.getSeats();
    }

    public List<Train> searchTrains(String source, String destination) {
        return trainList.stream().filter(train -> validTrain(train, source, destination)).collect(Collectors.toList());
    }

    private boolean validTrain(Train train, String source, String destination){
        List<String> stations = train.getStations();

        int sourceID = stations.indexOf(source.toLowerCase());
        int destID = stations.indexOf(destination.toLowerCase());

        return sourceID != -1 && destID != -1 && sourceID < destID; 
    }

}
