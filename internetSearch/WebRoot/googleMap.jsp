<!DOCTYPE html "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
 <html xmlns="http://www.w3.org/1999/xhtml">
   <head>
     <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
     <title>Google Maps JavaScript API Example</title>
     <script src=http://ditu.google.cn/maps?file=api&v=2&key=abcdefg&sensor=true type="text/javascript"> </script>
     <script type="text/javascript">
         function initialize()
         {
             if (GBrowserIsCompatible())
             {
                 var map = new Map2(document.getElementById("map_canvas"));
                 map.setCenter(new GLatLng(39.9493, 116.3975), 13);
             }
         }
     </script>
   </head>