package tv;

public class TV {
    private int channel;
    private int volume;
    private boolean power;

    public TV(int channel, int volume, boolean power) {
        this.channel = channel;
        this.volume = volume;
        this.power = power;
    }

    public void status() {
        System.out.println("TV[channel=" + channel + ", volume=" + volume + ", power=" + (power ? "on" : "off") + "]");
    }

    // 가급적 중복 코드가 없게
    public void power(boolean bool){
        power = bool;
    }

    public void channel(boolean bool) {
        if (bool) { // 채널 올리기
            channel += 1;
            if (channel > 255) {
                channel = 1;
            }
        } else {
            channel -= 1;
            if (channel < 1) {
                channel = 255;
            }
        }
    }

    public void channel(int i) {
        if (i <= 0) {
            channel = 255;
        } else if (i > 255) {
            channel = 1;
        } else {
            channel = i;
        }
    }

    public void volume(int v) {
        if (v < 0) {
            volume = 100;
        } else if (v > 100) {
            volume = 0;
        } else {
            volume = v;
        }
    }

    public void volume(boolean bool) {
        if (bool) {
            volume += 1;
            if (volume > 100) {
                volume = 0;
            }
        } else {
            volume -= 1;
            if (volume < 0) {
                volume = 100;
            }
        }
    }
}
