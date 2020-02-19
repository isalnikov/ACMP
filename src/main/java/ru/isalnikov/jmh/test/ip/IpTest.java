/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

Benchmark         Mode  Cnt    Score    Error  Units
IpTest.ipToLong   avgt   10  881,229 ± 12,035  ns/op
IpTest.ipToLong2  avgt   10  466,520 ± 22,463  ns/op
IpTest.longToIp   avgt   10  246,252 ± 57,698  ns/op
IpTest.longToIp2  avgt   10  346,085 ± 28,556  ns/op

 */
package ru.isalnikov.jmh.test.ip;

import ru.isalnikov.jmh.test.sort.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@Warmup(iterations = 3)
@Measurement(iterations = 10)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class IpTest {
    
    
//255.255.255.255  <->  4294967295
//192.168.1.2      <->  3232235778
  //  @Param({"4294967295", "3232235778"})
  //  long arrayLong;
    
//    @Param({"255.255.255.255", "192.168.1.2"})
//    String arrayString;
    
    public static long arrayLong[]  ={4294967295L, 3232235778L};
    
    public static String arrayString[]  ={"255.255.255.255", "192.168.1.2"};
    
    // example : 192.168.1.2
	public long ipToLong(String ipAddress) {

		// ipAddressInArray[0] = 192
		String[] ipAddressInArray = ipAddress.split("\\.");

		long result = 0;
		for (int i = 0; i < ipAddressInArray.length; i++) {

			int power = 3 - i;
			int ip = Integer.parseInt(ipAddressInArray[i]);

			// 1. 192 * 256^3
			// 2. 168 * 256^2
			// 3. 1 * 256^1
			// 4. 2 * 256^0
			result += ip * Math.pow(256, power);

		}

		return result;

	}

	public long ipToLong2(String ipAddress) {

		long result = 0;

		String[] ipAddressInArray = ipAddress.split("\\.");

		for (int i = 3; i >= 0; i--) {

			long ip = Long.parseLong(ipAddressInArray[3 - i]);

			// left shifting 24,16,8,0 and bitwise OR

			// 1. 192 << 24
			// 1. 168 << 16
			// 1. 1 << 8
			// 1. 2 << 0
			result |= ip << (i * 8);

		}

		return result;
	}

	public String longToIp(long i) {

		return ((i >> 24) & 0xFF) + 
                   "." + ((i >> 16) & 0xFF) + 
                   "." + ((i >> 8) & 0xFF) + 
                   "." + (i & 0xFF);

	}

	public String longToIp2(long ip) {
		StringBuilder sb = new StringBuilder(15);

		for (int i = 0; i < 4; i++) {

			// 1. 2
			// 2. 1
			// 3. 168
			// 4. 192
			sb.insert(0, Long.toString(ip & 0xff));

			if (i < 3) {
				sb.insert(0, '.');
			}

			// 1. 192.168.1.2
			// 2. 192.168.1
			// 3. 192.168
			// 4. 192
			ip = ip >> 8;

		}

		return sb.toString();
	}
    



    @Benchmark
    public void ipToLong(Blackhole bh) {
        long s = 0;
        for (String it : arrayString) {
            s = ipToLong("255.255.255.255");
        }

        bh.consume(s);

    }

    @Benchmark
    public void ipToLong2(Blackhole bh) {
        long s = 0;
        for (String it : arrayString) {
            s = ipToLong2("255.255.255.255");
        }

        bh.consume(s);
    }

    @Benchmark
    public void longToIp(Blackhole bh) {
        String s = null;
        for (long it : arrayLong) {
            s = longToIp(4294967295L);
        }

        bh.consume(s);
    }

    @Benchmark
    public void longToIp2(Blackhole bh) {
        String s = null;
        for (long it : arrayLong) {
            s = longToIp2(4294967295L);
        }

        bh.consume(s);
    }



    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(IpTest.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
