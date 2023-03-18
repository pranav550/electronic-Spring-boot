package org.example.services;

public class GSTService {

    private GstProvider gstProvider;

    public GSTService(GstProvider gstProvider) {
        this.gstProvider = gstProvider;
    }

    public int calculateGST(){
        System.out.println("Calculating GST");
        int rate = this.gstProvider.getGSTDetail();
        System.out.println("Gst rate is "+rate);
        return rate;
    }


}
