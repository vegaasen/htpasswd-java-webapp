jQuery(".result code.r").zclip({
    path: "/app/js/jquery/hacks/ZeroClipboard.swf",
    copy: function() {
        return jQuery(this).text();
    }});