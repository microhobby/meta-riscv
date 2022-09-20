require recipes-kernel/linux/linux-mainline-common.inc
FILESEXTRAPATHS:prepend = "${FILE_DIRNAME}/linux-nezha:"
SUMMARY = "Nezha dev kernel recipe"

SRCREV_meta ?= "ddb7fe05a2e7050ff604639a0dd53a862902b949"
SRCREV_machine ?= "77fca1978d056c57059dfc611585cec0e0b729ec"
FORK ?= "microhobby"
BRANCH ?= "nezha-d1"
KMETA = "kernel-meta"

# It is necessary to add to SRC_URI link to the 'yocto-kernel-cache' due to
# override of the original SRC_URI:
# "do_kernel_metadata: Check the SRC_URI for meta-data repositories or
# directories that may be missing"
SRC_URI = " \
        git://github.com/${FORK}/linus-tree.git;name=machine;protocol=https;branch=${BRANCH} \
        git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-5.19;destsuffix=${KMETA} \
    "

LINUX_VERSION ?= "5.19.0"
LINUX_VERSION_EXTENSION:append ?= "-nezha"

KERNEL_FEATURES += "features/cgroups/cgroups.cfg"
KERNEL_FEATURES += "ktypes/standard/standard.cfg"

KBUILD_DEFCONFIG = "nezha_defconfig"

COMPATIBLE_MACHINE = "(nezha-allwinner-d1)"
