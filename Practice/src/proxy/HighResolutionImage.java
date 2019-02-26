package proxy;

/**
 * RealSubject
 */
public class HighResolutionImage implements Image {

    public HighResolutionImage(String imageFilePath) {
        
        loadImage(imageFilePath);
    }

    private void loadImage(String imageFilePath) {
        System.out.println("loading image..this is heavy and costly operation..");
        // load Image from disk into memory
        // this is heavy and costly operation
    }

    @Override
    public void showImage() {
        System.out.println("showing image");
        // Actual Image rendering logic

    }

}