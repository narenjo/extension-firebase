package extension.firebase;

#if cpp
import cpp.Lib;
#elseif neko
import neko.Lib;
#end

#if (android && openfl)
import openfl.utils.JNI;
#end


class Firebase {
	
	
	public static function sendAnalyticsEvent (eventName:String, payload:String):Void {

		#if (ios || android)
			extension_firebase_send_analytics_event(eventName, payload);
		#else
			trace("sendAnalyticsEvent not implemented on this platform.");
		#end
	}

	/*public static function getInstanceIDToken ():String {

		#if (ios || android)
			return extension_firebase_get_instance_id_token();
		#else
		trace("getInstanceIDToken not implemented on this platform.");
		return null;
		#end
	}*/



	#if (ios)
	private static var extension_firebase_send_analytics_event = CFFI.load ("firebase", "sendFirebaseAnalyticsEvent", 2);
	//private static var extension_firebase_get_instance_id_token = CFFI.load ("firebase", "getInstanceIDToken", 0);
	#end

	#if (android)
	private static var extension_firebase_send_analytics_event = JNI.createStaticMethod("org.haxe.extension.Firebase", "sendFirebaseAnalyticsEvent", "(Ljava/lang/String;Ljava/lang/String;)V");
	//private static var extension_firebase_get_instance_id_token = JNI.createStaticMethod("org.haxe.extension.Firebase", "getInstanceIDToken", "()Ljava/lang/String;");
	#end
	
	
}