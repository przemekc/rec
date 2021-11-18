package pl.yellowduck.recruiting.streams;

import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomUtils;

import java.util.stream.IntStream;

public class ParallerStreamsMain {

  @SneakyThrows
  public static void main(String[] args) {
    IntStream.generate(RandomUtils::nextInt)
        .parallel()
        .peek(System.out::println)
        .limit(10);
  }
}