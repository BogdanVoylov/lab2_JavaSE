package com.company.model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BufferedImageWrapper implements Serializable {
    private BufferedImage image;

    public BufferedImageWrapper(BufferedImage bufferedImage) {
        this.image = bufferedImage;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        ImageIO.write(image,"jpg",out);
    }

    private void readObject(ObjectInputStream in) throws IOException {
        image = ImageIO.read(in);
    }
}
