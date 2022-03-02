import android.net.Uri;

public class GiftItems {
    public Uri image;

    public GiftItems(Uri image){
        this.image = image;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }
}
