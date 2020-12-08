package com.cscl.poll.portlet.util;

import java.util.Set;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;

public class DLFileUtil {
	public static String getNewFileName(Folder folder, String fileName) {
		String fname = "";
		int counter = 0;
		try {
			FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(folder.getGroupId(), folder.getFolderId(), fileName);

			if (null != fileEntry) {
				counter++;

				while (counter != 0) {
					String name = fileName.substring(0, fileName.lastIndexOf("."));
					String ext = fileName.substring(fileName.lastIndexOf("."));
					fname = name + "_" + counter + ext;
					try {
						FileEntry fileEntry1 = DLAppLocalServiceUtil.getFileEntry(folder.getGroupId(), folder.getFolderId(), fname);

						if (null != fileEntry1) {
							counter++;
						} else {
							counter = 0;
						}
					} catch (Exception e) {
						counter = 0;
					}
				}

			} else {
				return fileName;
			}
		} catch (Exception e) {
			fname = fileName;
		}

		return fname;
	}

	public static String getNewFileName(Set<String> nameSet, String fileName) {
		String fname = fileName;
		int counter = 0;
		try {

			counter++;
			while (counter != 0) {
				String name = fileName.substring(0, fileName.lastIndexOf("."));
				String ext = fileName.substring(fileName.lastIndexOf("."));
				fname = name + "_" + counter + ext;
				try {

					if (nameSet.contains(fname)) {
						counter++;
					} else {
						counter = 0;
					}
				} catch (Exception e) {
					counter = 0;
				}
			}

		} catch (Exception e) {
			fname = fileName;
		}

		return fname;
	}

	public static Folder getBlogFolder(long groupId, long userId, long entryId, String parentFolderName) {
		Folder blogFolder = null;
		Folder folder = null;

		ServiceContext serviceContext = new ServiceContext();
		//serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
		//serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setAddGroupPermissions(true);
		serviceContext.setScopeGroupId(groupId);

		try {
			folder = DLAppLocalServiceUtil.getFolder(groupId,
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
					parentFolderName);
			_log.error("Parent Folder Found:" + parentFolderName);
		} catch (Exception e) {
			_log.error("Parent Folder Not Found:" + parentFolderName);
			try {
				folder = DLAppLocalServiceUtil.addFolder(userId, groupId,
						DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
						parentFolderName, parentFolderName, serviceContext);
				_log.error("Parent Folder Created:" + parentFolderName);
			} catch (Exception e1) {
				_log.error("Parent Folder Creation Failed:"
						+ parentFolderName);
			}
		}

		try {
			// Find Sub folder

			blogFolder = DLAppLocalServiceUtil.getFolder(groupId,
					folder.getFolderId(), String.valueOf(entryId));
			_log.error("Sub Folder Found:" + String.valueOf(entryId));
		} catch (Exception e) {
			_log.error("Sub Folder Not Found:"
					+ String.valueOf(entryId));
			try {
				blogFolder = DLAppLocalServiceUtil.addFolder(userId,
						folder.getRepositoryId(), folder.getFolderId(),
						String.valueOf(entryId), String.valueOf(entryId),
						serviceContext);
				_log.error("Sub Folder Created:"
						+ String.valueOf(entryId));
			} catch (Exception e1) {
				_log.error("Sub Folder Creation Failed:"
						+ String.valueOf(entryId));
			}
		}

		return blogFolder;
	}
	
	public static DLFolder getBlogFolder(long groupId, long entryId, String parentFolderName) {
		DLFolder blogFolder = null;
		// For file upload
		DLFolder folder = null;
		try {
			folder = DLFolderLocalServiceUtil.getFolder(groupId, 0, parentFolderName);
		} catch (Exception e) {}

		try {
			if (folder != null) {
				blogFolder = DLFolderLocalServiceUtil.getFolder(groupId, folder.getFolderId(), entryId + "");
			}
		} catch (PortalException e) {
			_log.error("No folder found with folder Id:"+entryId);
		} catch (SystemException e) {
			_log.error("No folder found with folder Id:"+entryId);
		}

		return blogFolder;
	}
	public static String getNewFileForComment(FileEntry folder, String fileName) {
		String fname = "";
		int counter = 0;
		try {
			FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(folder.getGroupId(), folder.getFolderId(), fileName);

			if (null != fileEntry) {
				counter++;

				while (counter != 0) {
					String name = fileName.substring(0, fileName.lastIndexOf("."));
					String ext = fileName.substring(fileName.lastIndexOf("."));
					fname = name + "_" + counter + ext;
					try {
						FileEntry fileEntry1 = DLAppLocalServiceUtil.getFileEntry(folder.getGroupId(), folder.getFolderId(), fname);

						if (null != fileEntry1) {
							counter++;
						} else {
							counter = 0;
						}
					} catch (Exception e) {
						counter = 0;
					}
				}

			} else {
				return fileName;
			}
		} catch (Exception e) {
			fname = fileName;
		}

		return fname;
	}
	
	public static Log _log = LogFactoryUtil.getLog(DLFileUtil.class);
}
