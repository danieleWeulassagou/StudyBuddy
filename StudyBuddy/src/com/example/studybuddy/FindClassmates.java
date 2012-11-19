package com.example.studybuddy;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class FindClassmates extends MapActivity {
    
    private MapView mapView;
    
    
    private static final int latitudeE6 = 42291159;
    private static final int longitudeE6 = -83715762;
    
    private static final int pontlat=42291059;
    private static final int pontlon=-83715762;
    private static final int eecslat=42292367;
    private static final int eecslon=-83714019;

    

    public void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmaps);
        
        mapView = (MapView) findViewById(R.id.map_view);       
        mapView.setBuiltInZoomControls(true);
        
        List mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.gree);
        Drawable medrawable = this.getResources().getDrawable(R.drawable.red);

        CustomItemizedOverlay itemizedOverlay = 
             new CustomItemizedOverlay(drawable, this);
       
        CustomItemizedOverlay meitemizedOverlay = 
                new CustomItemizedOverlay(medrawable, this);
        
        GeoPoint point = new GeoPoint(latitudeE6, longitudeE6);
        OverlayItem overlayitem = 
             new OverlayItem(point, "Brian Kaufman","");
        
        GeoPoint p2=new GeoPoint(pontlat,pontlon);
        OverlayItem overlayitem2 = 
                new OverlayItem(p2, "Daniele Weulassagou", "Near Mujo");
        GeoPoint p3=new GeoPoint(eecslat,eecslon);
        OverlayItem overlayitem3 = 
                new OverlayItem(p3, "Peter Bondra", "I'll be here all night");
        

        itemizedOverlay.addOverlay(overlayitem2);
        itemizedOverlay.addOverlay(overlayitem3);
        meitemizedOverlay.addOverlay(overlayitem);
        mapOverlays.add(itemizedOverlay);
        mapOverlays.add(meitemizedOverlay);
        
        MapController mapController = mapView.getController();
        
        mapController.animateTo(point);
        mapController.setZoom(17);
        
    }


    protected boolean isRouteDisplayed() {
        return false;
    }
    
}