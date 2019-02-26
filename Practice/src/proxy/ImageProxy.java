package proxy;

/**
 * Proxy
 */
public class ImageProxy implements Image {

    /**
     * Private Proxy data 
     */
    private String imageFilePath;
    
    /**
     * Reference to RealSubject
     */
    private Image proxifiedImage;
    
    
    public ImageProxy(String imageFilePath) {
        System.out.println("This is : " + imageFilePath) ;
        this.imageFilePath= imageFilePath;  
    }
    
    @Override
    public void showImage() {

        // create the Image Object only when the image is required to be shown
        
        proxifiedImage = new HighResolutionImage(imageFilePath);
        
        // now call showImage on realSubject
        proxifiedImage.showImage();
        
    }

}