package track.container;

import java.io.File;
import java.io.IOException;
import java.util.List;

import track.container.config.Bean;
import track.container.config.ConfigReader;
import track.container.config.InvalidConfigurationException;
import track.container.config.Root;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonConfigReader implements ConfigReader {

    @Override
    public List<Bean> parseBeans(File configFile) throws InvalidConfigurationException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Root root = mapper.readValue(configFile, Root.class);

            return root.getBeans();

        } catch (IOException e) {
            throw new InvalidConfigurationException(e.getMessage());
        }
    }
}


