import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileUtils extends SimpleFileVisitor<Path> {

    Path sourcePath;
    Path pathWhereCopy;


    FileUtils(Path sourcePath, Path pathWhereCopy) {

        this.sourcePath = sourcePath;
        this.pathWhereCopy = pathWhereCopy;

    }


    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path targetPhat = pathWhereCopy.resolve(sourcePath.relativize(dir));

        if (!targetPhat.toFile().exists()) {
            Files.createDirectory(targetPhat);
        }

        return FileVisitResult.CONTINUE;
    }


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException {

        Path targetPath = pathWhereCopy.resolve(sourcePath.relativize(file));
        Files.copy(file, targetPath, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);


        return FileVisitResult.CONTINUE;
    }


    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {

        Path path = Paths.get(sourceDirectory);
        Path path1 = Paths.get(destinationDirectory);

        Files.walkFileTree(path, new FileUtils(path, path1));


    }

}
