package ocp.nio;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.CopyOption;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.sun.scenario.effect.impl.state.LinearConvolveKernel;

import tgipl.test.TestAbstract;

public class TestPathsMethods {
	public static void main(String[] args) {
		
		testPathsGet();
		
		testmkdirs();
		testMove();
		
		testExe();
		testReadAllines();
		
		testFileSystems();
		
		testAttributes();
		
		testDirectoryWalker();
		
		testFinder();
	}

	private static void testFinder() {

		Path path = Paths.get("F:\\WorkSpace\\DesignPatterns\\src\\patterns");
		try {
			Files.find(path, 10, (p,a) ->p.toString().endsWith(".java")&& !a.isDirectory())
			.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("_____________________________________________________________________________________");
		try {
			Files.list(path).filter(p-> !Files.isDirectory(p)).forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
	}

	private static void testDirectoryWalker() {
		Path path = Paths.get("F:\\WorkSpace\\DesignPatterns\\src\\patterns");
		try {
			Files.walk(path, 10)
			.filter(p->p.toString().endsWith(".java"))
			.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void testAttributes() {

		Path exe = Paths.get("D:\\Chrome_Downloads\\winrar-x64-550.exe");
		
		try {
		BasicFileAttributes fileAttributes= 	Files.readAttributes(exe, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
		System.out.println(fileAttributes.fileKey());
		System.out.println(fileAttributes.creationTime().toInstant());
		System.out.println(fileAttributes.lastAccessTime().toInstant());
		System.out.println(fileAttributes.lastModifiedTime().toInstant());
		
		BasicFileAttributeView view = Files.getFileAttributeView(exe, BasicFileAttributeView.class, LinkOption.NOFOLLOW_LINKS);
		view.setTimes(null, null, FileTime.from(Instant.now()));
		
		BasicFileAttributes fileAttributes1= 	Files.readAttributes(exe, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
		System.out.println(fileAttributes1.fileKey());
		System.out.println(fileAttributes1.creationTime().toInstant());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}

	private static void testExe() {
		Path exe = Paths.get("D:\\Chrome_Downloads\\winrar-x64-550.exe");
		
		System.out.println(Files.isExecutable(exe));
		System.out.println(Files.isReadable(exe));
		try {
			System.out.println(Files.getOwner(exe, LinkOption.NOFOLLOW_LINKS));
			UserPrincipal user = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("administrator");
			System.out.println(user.getName());
			Files.setOwner(exe, user);
			System.out.println(Files.getOwner(exe, LinkOption.NOFOLLOW_LINKS));
			System.out.println(Files.isHidden(exe));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void testReadAllines() {

		Path path = Paths.get("F:\\WorkSpace\\DesignPatterns\\src\\patterns\\creational\\factorymethod\\ProductFactory.java"); //F:\ocp\nio\test
		System.out.println(Files.exists(path, LinkOption.NOFOLLOW_LINKS));
		Path exe = Paths.get("D:\\Chrome_Downloads\\winrar-x64-550.exe");
		
		System.out.println(Files.isExecutable(exe));
		
		try {
			 Files.readAllLines(path).stream().forEach(System.out::println);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}

	private static void testMove() {

		Path path = Paths.get("F://ocp/test/rajiv"); //F:\ocp\nio\test
		System.out.println(Files.exists(path, LinkOption.NOFOLLOW_LINKS));
		Path path2 = Paths.get("F://ocp2/");
		try {
			Files.move(path,path2,StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}

	private static void testmkdirs() {
		Path path = Paths.get("F://ocp/nio/test/text.txt"); //F:\ocp\nio\test
		System.out.println(Files.exists(path, LinkOption.NOFOLLOW_LINKS));
		Path path2 = Paths.get("F://ocp1/test.txt");
		try {
			Files.copy(path,path2,StandardCopyOption.REPLACE_EXISTING);
			Files.copy(path,path2,LinkOption.NOFOLLOW_LINKS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void testFileSystems() {
		FileSystem fileSystem = FileSystems.getDefault();
		System.out.println(fileSystem.toString());
		try {
			FileSystem googleFileSystem = FileSystems.getFileSystem(new URI("http://www.selikoff.net"));
			System.out.println(googleFileSystem.toString());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void testPathsGet()  {
		Path path1 = Paths.get("F:","ocp", "test");
		Path path2;
		try {
			path2 = Paths.get("F:","ocp", "nio", "test").toRealPath(new LinkOption[0]);
			System.out.println(path1.isAbsolute());
			System.out.println(path2.toAbsolutePath());
			System.out.println(path2.relativize(path2));
			System.out.println(path2.resolve(path2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*try {
			System.out.println(path.toRealPath(null));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

}
